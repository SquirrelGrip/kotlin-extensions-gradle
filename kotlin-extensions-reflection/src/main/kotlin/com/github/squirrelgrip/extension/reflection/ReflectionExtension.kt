package com.github.squirrelgrip.extension.reflection

import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Field
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

fun Any.toClass(): Class<*> = this::class.java
fun Any.toMethods(): Array<out Method> = this::class.java.methods
fun Any.toFields(): Array<out Field> = this::class.java.fields
fun Any.toConstructors(): Array<out Constructor<*>> = this::class.java.constructors
fun Any.toAnnotations(): Array<out Annotation> = this::class.java.annotations

fun Any.toKClass(): KClass<*> = this::class
fun Any.toKMembers(): Collection<KCallable<*>> = this::class.members
fun Any.toKAnnotations(): List<Annotation> = this::class.annotations
fun Any.toKConstructors(): Collection<KFunction<*>> = this::class.constructors
