// Generated from D:/project_myself/demo-tim/demo-common/src/main/java/com/tim/common/antlr\SelectExample1.g4 by ANTLR 4.7.2
package com.tim.common.antlr.gen;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SelectExample1Visitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SelectExample1BaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SelectExample1Visitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSql(SelectExample1Parser.SqlContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTables(SelectExample1Parser.TablesContext ctx) { return visitChildren(ctx); }
}