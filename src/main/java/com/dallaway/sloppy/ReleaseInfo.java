/*
 * Copyright (C) 2001-2010 Richard Dallaway <richard@dallaway.com>
 * 
 * This file is part of Sloppy.
 * 
 * Sloppy is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Sloppy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Sloppy; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.dallaway.sloppy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * The sloppy project release information.
 */
public class ReleaseInfo
{
	/**
	 * @return an identifying label for this release.
	 */
	public String getRelease()
	{
        return Messages.getString("sloppy.majorVersion")+"."+getBuildNumber() + " ("+Locale.getDefault()+")"; //$NON-NLS-1$
	}	

	/**
	 * @return The current build number, or null if not set, or
	 * 			an exception message if the build info could not be read.
	 */
	private String getBuildNumber() 
	{	
		Properties props = new Properties();
		try
		{
			InputStream in = getClass().getResourceAsStream("/build.properties"); //$NON-NLS-1$
			if (in != null)
			{
				props.load(in);
				in.close();
			}
		}
		catch (IOException iox)
		{
			return iox.getMessage();	
		}
		return props.getProperty("build.number"); //$NON-NLS-1$
		
	}

	/**
	 * This is the standard GPL short notice.
	 * 
	 * @return A copyright notice for this release.
	 */	
	public String getCopyright()
	{
		return
			Messages.getString("license.title")+ //$NON-NLS-1$
			Messages.getString("license.short"); //$NON-NLS-1$

		
	}
	
}
