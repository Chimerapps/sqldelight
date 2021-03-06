package com.squareup.sqldelight.core.lang.util

import com.alecstrong.sql.psi.core.psi.SqlCreateTableStmt
import com.squareup.kotlinpoet.ClassName
import com.squareup.sqldelight.core.compiler.SqlDelightCompiler.allocateName
import com.squareup.sqldelight.core.psi.SqlDelightColumnDef

internal val SqlCreateTableStmt.columns: List<SqlDelightColumnDef>
  get() = columnDefList.filterIsInstance<SqlDelightColumnDef>()

internal val SqlCreateTableStmt.interfaceType: ClassName
  get() = ClassName(sqFile().packageName!!, allocateName(tableName).capitalize())
