package com.microsoft.azure.storage.table;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Ignore {}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.Ignore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */