package com.octacoresoftwares.remote.mappers

import com.octacoresoftwares.remote.model.BankModel
import com.octacoresoftwares.remote.model.BinResponseModel
import com.octacoresoftwares.remote.model.CountryModel
import com.octacoresoftwares.remote.model.NumberModel
import com.octacoresoftwares.repository.model.BankEntity
import com.octacoresoftwares.repository.model.BinResponseEntity
import com.octacoresoftwares.repository.model.CountryEntity
import com.octacoresoftwares.repository.model.NumberEntity

fun BinResponseModel.toRepo(): BinResponseEntity =
    BinResponseEntity(
        number = number.toRepo(),
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        country = country.toRepo(),
        bank = bank.toRepo()
    )

fun NumberModel?.toRepo(): NumberEntity =
    NumberEntity(
        length = this?.length,
        luhn = this?.luhn
    )

fun CountryModel?.toRepo(): CountryEntity =
    CountryEntity(
        numeric = this?.numeric,
        alpha = this?.alpha,
        name = this?.name,
        emoji = this?.emoji,
        currency = this?.currency,
        latitude = this?.latitude,
        longitude = this?.longitude
    )

fun BankModel?.toRepo(): BankEntity =
    BankEntity(
        name = this?.name,
        url = this?.url,
        phone = this?.phone,
        city = this?.city
    )