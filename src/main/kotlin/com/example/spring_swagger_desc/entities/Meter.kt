package com.example.spring_swagger_desc.entities

import io.swagger.annotations.ApiModel
import java.time.Instant

enum class EntityType {
    Entity1, Entity2
}

@ApiModel(
    subTypes = arrayOf(Entity1::class, Entity2::class),
    discriminator = "type"
)
abstract class IEntity {
    abstract val prop1: String
    abstract val type: EntityType
}

@ApiModel(parent = IEntity::class)
class Entity1(override val prop1: String) : IEntity() {
    override val type: EntityType = EntityType.Entity1
}

@ApiModel(parent = IEntity::class)
class Entity2(override val prop1: String, val prop2: Int) : IEntity() {
    override val type: EntityType = EntityType.Entity2
}

data class Meter(
    val id: String,
    val serial: String,
    val created: Instant,
    val readings: List<Reading>,
    val readingsMap: Map<String, Reading>,
    val readingsSet: Set<Reading>,
    val abc: ABC,
    val dce: DCE,
    val you: YUO,
    val entity: IEntity,
    val entities: List<IEntity>,
    val entitiesMap: Map<String, IEntity>,
    val entitiesSet: Set<IEntity>,
) {
    enum class ABC {
        A, B, C
    }

    enum class DCE(val t: Int) {
        D(5), C(6), E(7)
    }

    enum class YUO(val t: String) {
        Y("yyy"), U("uuu"), O("ooo")
    }
}

data class Reading(val value: Double)