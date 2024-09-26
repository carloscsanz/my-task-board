package com.carloscsanz.mytaskboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyTaskBoardApplication

fun main(args: Array<String>) {
    runApplication<MyTaskBoardApplication>(*args)
}
