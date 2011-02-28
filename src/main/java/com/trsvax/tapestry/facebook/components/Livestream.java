package com.trsvax.tapestry.facebook.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.tapestry.facebook.services.FBAsyncSupport;


/**
 * @author bfb
 * Facebook XFBML Livestream component
 * @see <a href="http://developers.facebook.com/docs/reference/plugins/facepile/">Livestream</a>
 *
 */
@SupportsInformalParameters
public class Livestream {
	
	@Inject
	private ComponentResources componentResources;
	
	@Environmental
	private FBAsyncSupport fbAsyncSupport;

	@BeginRender
	void beginRender(MarkupWriter writer) {
		fbAsyncSupport.render();
		writer.element("fb:live-stream");
		componentResources.renderInformalParameters(writer);
		writer.end();
	}


}