package com.studerw.datastructures;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * An abstract class with helper methods for use within tests.
 */
public abstract class TestBase
{
	/**
	 * Creates a reader for a resource in the relative path.
	 * @param relativePath path to the file relative to the {@code /src/test/resources} directory, starting with a slash {@code /}
	 * @return a reader of the resource
	 */
	public static Reader getReader( final String relativePath )
	{
		try
		{
			return new InputStreamReader( TestBase.class.getResourceAsStream( relativePath ), "UTF-8" );
		}
		catch ( UnsupportedEncodingException e )
		{
			throw new IllegalStateException( "Unable to read input", e );
		}
	}

	/**
	 * Creates a {@link java.io.File File} instance from a resource in the relative path.
	 * @param relativePath path to the file relative to the {@code /src/test/resources} directory, starting with a slash {@code /}
	 * @return a File instance of the resource by relative path
	 */
	public static File getFile( final String relativePath )
	{
		return new File(TestBase.class.getResource( relativePath ).getFile());
	}
}
