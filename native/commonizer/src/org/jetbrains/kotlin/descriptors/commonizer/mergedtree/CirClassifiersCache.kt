/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.descriptors.commonizer.mergedtree

import gnu.trove.THashMap
import org.jetbrains.kotlin.name.ClassId

interface CirClassifiersCache {
    fun classNode(classId: ClassId): CirClassNode?
    fun typeAliasNode(typeAliasId: ClassId): CirTypeAliasNode?

    fun addClassNode(classId: ClassId, node: CirClassNode)
    fun addTypeAliasNode(typeAliasId: ClassId, node: CirTypeAliasNode)
}

class DefaultCirClassifiersCache : CirClassifiersCache {
    private val classNodes = THashMap<ClassId, CirClassNode>()
    private val typeAliases = THashMap<ClassId, CirTypeAliasNode>()

    override fun classNode(classId: ClassId): CirClassNode? = classNodes[classId]
    override fun typeAliasNode(typeAliasId: ClassId): CirTypeAliasNode? = typeAliases[typeAliasId]

    override fun addClassNode(classId: ClassId, node: CirClassNode) {
        val oldNode = classNodes.put(classId, node)
        check(oldNode == null) { "Rewriting class node $classId" }
    }

    override fun addTypeAliasNode(typeAliasId: ClassId, node: CirTypeAliasNode) {
        val oldNode = typeAliases.put(typeAliasId, node)
        check(oldNode == null) { "Rewriting type alias node $typeAliasId" }
    }
}
