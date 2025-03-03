/*
 * Copyright 2015-2025 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.api.tools;

import java.io.PrintWriter;

/**
 * @since 1.0
 */
class AsciidocApiReportWriter extends AbstractApiReportWriter {

	private static final String ASCIIDOC_FORMAT = "| %-52s | %-" + NAME_COLUMN_WIDTH + "s | %-12s%n";

	AsciidocApiReportWriter(ApiReport apiReport) {
		super(apiReport);
	}

	@Override
	protected String h1(String header) {
		return "= " + header;
	}

	@Override
	protected String h2(String header) {
		return "== " + header;
	}

	@Override
	protected String code(String element) {
		return "`" + element + "`";
	}

	@Override
	protected String italic(String element) {
		return "_" + element + "_";
	}

	@Override
	protected void printDeclarationTableHeader(PrintWriter out) {
		out.println("|===");
		out.printf(ASCIIDOC_FORMAT, "Package Name", "Name", "Since");
		out.println();
	}

	@Override
	protected void printDeclarationTableRow(Declaration declaration, PrintWriter out) {
		out.printf(ASCIIDOC_FORMAT, //
			code(declaration.packageName()), //
			code(declaration.name()) + " " + italic("(" + declaration.kind() + ")"), //
			code(declaration.since()) //
		);
	}

	@Override
	protected void printDeclarationTableFooter(PrintWriter out) {
		out.println("|===");
	}

}
