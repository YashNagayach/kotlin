/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.generators.tests

import org.jetbrains.kotlin.checkers.AbstractForeignJava8AnnotationsNoAnnotationInClasspathTest
import org.jetbrains.kotlin.checkers.AbstractForeignJava8AnnotationsNoAnnotationInClasspathWithPsiClassReadingTest
import org.jetbrains.kotlin.checkers.AbstractForeignJava8AnnotationsTest
import org.jetbrains.kotlin.checkers.javac.AbstractJavacForeignJava8AnnotationsTest
import org.jetbrains.kotlin.generators.tests.generator.testGroupSuite
import org.jetbrains.kotlin.jvm.compiler.AbstractLoadJava8Test
import org.jetbrains.kotlin.jvm.compiler.AbstractLoadJava8WithPsiClassReadingTest
import org.jetbrains.kotlin.jvm.compiler.javac.AbstractLoadJava8UsingJavacTest
import org.jetbrains.kotlin.resolve.calls.AbstractEnhancedSignaturesResolvedCallsTest

fun main(args: Array<String>) {
    System.setProperty("java.awt.headless", "true")

    testGroupSuite(args) {
        testGroup("compiler/tests-java8/tests", "compiler/testData") {
            testClass<AbstractForeignJava8AnnotationsTest> {
                model("foreignAnnotationsJava8/tests")
            }

            testClass<AbstractJavacForeignJava8AnnotationsTest> {
                model("foreignAnnotationsJava8/tests")
            }

            testClass<AbstractForeignJava8AnnotationsNoAnnotationInClasspathTest> {
                model("foreignAnnotationsJava8/tests")
            }

            testClass<AbstractForeignJava8AnnotationsNoAnnotationInClasspathWithPsiClassReadingTest> {
                model("foreignAnnotationsJava8/tests")
            }

            testClass<AbstractLoadJava8Test> {
                model("loadJava8/compiledJava", extension = "java", testMethod = "doTestCompiledJava")
                model("loadJava8/sourceJava", extension = "java", testMethod = "doTestSourceJava")
            }

            testClass<AbstractLoadJava8UsingJavacTest> {
                model("loadJava8/compiledJava", extension = "java", testMethod = "doTestCompiledJava")
                model("loadJava8/sourceJava", extension = "java", testMethod = "doTestSourceJava")
            }

            testClass<AbstractLoadJava8WithPsiClassReadingTest> {
                model("loadJava8/compiledJava", extension = "java", testMethod = "doTestCompiledJava")
            }

            testClass<AbstractEnhancedSignaturesResolvedCallsTest> {
                model("resolvedCalls/enhancedSignatures")
            }
        }
    }
}
