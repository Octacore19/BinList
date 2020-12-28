package com.octacoresoftwares.repository.mappers

import com.octacoresoftwares.domain.model.Bank
import com.octacoresoftwares.domain.model.BinResponse
import com.octacoresoftwares.domain.model.Country
import com.octacoresoftwares.domain.model.Number
import com.octacoresoftwares.repository.model.BankEntity
import com.octacoresoftwares.repository.model.BinResponseEntity
import com.octacoresoftwares.repository.model.CountryEntity
import com.octacoresoftwares.repository.model.NumberEntity

fun BinResponseEntity.toResponse(): BinResponse =
    BinResponse(
        number = this.number?.toNumber(),
        scheme = this.scheme,
        type = this.type,
        brand = brand,
        prepaid = prepaid,
        country = country?.toCountry(),
        bank = bank?.toBank()
    )

fun NumberEntity.toNumber(): Number =
    Number(
        length = length,
        luhn = luhn
    )

fun CountryEntity.toCountry(): Country =
    Country(
        numeric = numeric,
        alpha = alpha,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude
    )

fun BankEntity.toBank(): Bank =
    Bank(
        name = name,
        url = url,
        phone = phone,
        city = city
    )