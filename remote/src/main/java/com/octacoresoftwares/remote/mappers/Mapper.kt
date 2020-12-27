package com.octacoresoftwares.remote.mappers

import com.octacoresoftwares.domain.model.BankModel
import com.octacoresoftwares.domain.model.BinResponseModel
import com.octacoresoftwares.domain.model.CountryModel
import com.octacoresoftwares.domain.model.NumberModel
import com.octacoresoftwares.repository.model.BankEntity
import com.octacoresoftwares.repository.model.BinResponseEntity
import com.octacoresoftwares.repository.model.CountryEntity
import com.octacoresoftwares.repository.model.NumberEntity

fun BinResponseModel.toRepo(): BinResponseEntity =
    BinResponseEntity(
        number = number.toRepo(),
        scheme = scheme ?: "N/A",
        type = type ?: "N/A",
        brand = brand ?: "N/A",
        prepaid = prepaid ?: false,
        country = country.toRepo(),
        bank = bank.toRepo()
    )

fun NumberModel?.toRepo(): NumberEntity =
    NumberEntity(
        length = this?.length ?: 0,
        luhn = this?.luhn ?: false
    )

fun CountryModel?.toRepo(): CountryEntity =
    CountryEntity(
        numeric = this?.numeric ?: "N/A",
        alpha = this?.alpha ?: "N/A",
        name = this?.name ?: "N/A",
        emoji = this?.emoji ?: "N/A",
        currency = this?.currency ?: "N/A",
        latitude = this?.latitude ?: 0.0,
        longitude = this?.longitude ?: 0.0
    )

fun BankModel?.toRepo(): BankEntity =
    BankEntity(
        name = this?.name ?: "N/A",
        url = this?.url ?: "N/A",
        phone = this?.phone ?: "N/A",
        city = this?.city ?: "N/A"
    )