#!/bin/bash
# Script de teste para o projeto Maven TensorLang

mvn clean generate-sources
mvn clean compile

java --enable-preview --add-modules jdk.incubator.vector -cp target/classes:target/generated-sources/antlr4:$(cat cp.txt) lang.Main program.tlang
