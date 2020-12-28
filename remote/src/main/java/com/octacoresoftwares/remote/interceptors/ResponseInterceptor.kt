package com.octacoresoftwares.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class ResponseInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = response.body()!!.string()
        val responseBody = try {
            JSONObject(body)
        } catch (e: Exception) {
            JSONArray(body)
        }

        var newResponseBody: Any? = null

        return when (responseBody) {
            is JSONObject -> {
                newResponseBody =
                    if (responseBody.has("errors") && responseBody.has("hasErrors") && responseBody.get(
                            "hasErrors"
                        ) as Boolean
                    ) {
                        /**
                         * An error from the server
                         */
                        val errorArray = responseBody.getJSONArray("errors")
                        // get the error from the object
                        val errorMessage = try {
                            JSONObject(errorArray[0].toString()).getString("message")
                        }
                        // ge the error from a string
                        catch (e: Exception) {
                            val errorString = "{ \"error\": \"${errorArray[0]}\"}";
                            JSONObject(errorString)
                        }
                        JSONObject().apply {
                            put("message", errorMessage)
                            put("success", false)
                            put("hasError", true)
                        }
                    } else if (responseBody.has("errorDescription") && (responseBody.get("errorDescription") as String).isNotEmpty()) {
                        val errorString =
                            "{ \"error\": \"${(responseBody.get("errorDescription") as String)}\"}";
                        JSONObject().apply {
                            put("message", JSONObject(errorString))
                            put("success", false)
                            put("hasError", true)
                        }
                    } else {
                        JSONObject().apply {
                            put("data", responseBody)
                            put("success", true)
                            put("hasError", false)
                        }
                    }
                response.newBuilder().body(
                    ResponseBody.create(response.body()!!.contentType(), newResponseBody.toString())
                ).build()
            }
            is JSONArray -> {
                val mainObject = JSONObject(responseBody[0].toString())
                newResponseBody = when {
                    mainObject.has("errors") -> {
                        /**
                         * An error from the server
                         */
                        val errorArray = mainObject.getJSONArray("errors")
                        val errorMessage = JSONObject(errorArray[0].toString()).getString("message")
                        JSONObject().apply {
                            put("message", errorMessage)
                            put("success", false)
                            put("hasError", true)
                        }
                    }
                    else -> JSONObject().apply {
                        put("data", responseBody)
                        put("success", true)
                        put("hasError", false)
                    }
                }
                response.newBuilder().body(
                    ResponseBody.create(response.body()!!.contentType(), newResponseBody.toString())
                ).build()
            }
            else -> {
                response.newBuilder().body(
                    ResponseBody.create(response.body()!!.contentType(), newResponseBody.toString())
                ).build()
            }
        }
    }
}