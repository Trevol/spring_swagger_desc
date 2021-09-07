package com.example.spring_swagger_desc.controllers

import com.example.spring_swagger_desc.entities.Entity1
import com.example.spring_swagger_desc.entities.Entity2
import com.example.spring_swagger_desc.entities.Meter
import com.example.spring_swagger_desc.entities.Reading
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/meter")
class MeterRestController {

    @GetMapping("")
            /*@ApiOperation(
                value = "list all meters",
                response = Meter::class
            )*/
    fun meters() = (1..3).map {
        Meter(
            id = it.toString(),
            serial = "Meter_$it",
            created = Instant.now(),
            readings = listOf(Reading(123.8)),
            readingsMap = mapOf("dddd" to Reading(666.888)),
            readingsSet = setOf(),
            abc = Meter.ABC.B,
            dce = Meter.DCE.E,
            you = Meter.YUO.U,
            entity = Entity1("wwww"),
            entities = listOf(Entity1("qqqqq"), Entity2("hhhhh", 567)),
            entitiesMap = mapOf(),
            entitiesSet = setOf()
        )
    }

    @PostMapping("/save")
    fun save(
        @RequestBody meter: Meter
    ): ResponseEntity<String> {
        return ResponseEntity("Saved", HttpStatus.OK)
    }
}