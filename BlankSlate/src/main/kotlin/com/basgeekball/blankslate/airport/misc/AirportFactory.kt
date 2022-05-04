package com.basgeekball.blankslate.airport.misc

import com.basgeekball.blankslate.airport.model.Airport
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import java.io.File
import java.io.FileReader
import java.io.Reader
import java.net.URL
import java.time.ZoneOffset

class AirportFactory {
    companion object {
        val CSV_FILE = "airports.csv"
        val HEADERS = arrayOf("IATA", "ICAO", "Airport Name", "Location Served", "Timezone", "DST")

        private fun parse(csvFile: String): Iterable<CSVRecord> {
            val resource: URL = this::class.java.classLoader.getResource(csvFile)
                ?: throw IllegalArgumentException("File not found: $csvFile")
            val reader: Reader = FileReader(File(resource.toURI()))
            val csvFormat: CSVFormat = CSVFormat.Builder.create()
                .setHeader(*HEADERS)
                .setSkipHeaderRecord(true)
                .build()
            return csvFormat.parse(reader)
        }

        private fun convert(records: Iterable<CSVRecord>): ArrayList<Airport> {
            val airports: ArrayList<Airport> = ArrayList()
            for (record in records) {
                val iata = record["IATA"]
                val icao = record["ICAO"].ifBlank { null }
                val name = record["Airport Name"]
                val location = record["Location Served"]
                val timezone = if (record["Timezone"].isBlank()) {
                    null
                } else {
                    ZoneOffset.of(Regex("UTC([+-]\\d{2}:\\d{2})").find(record["Timezone"])?.groupValues?.get(1))
                }
                val dst = if (record["DST"].isBlank()) {
                    null
                } else {
                    val (beginMonth, endMonth) = Regex("(\\w{3})-(\\w{3})").find(record["DST"])!!.destructured
                    Pair(MonthMapper.map(beginMonth)!!, MonthMapper.map(endMonth)!!)
                }
                airports.add(Airport(iata, icao, name, location, timezone, dst))
            }
            return airports
        }

        fun build(): ArrayList<Airport> {
            return convert(parse(CSV_FILE))
        }
    }
}