package com.appengine.gpgbdj;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Test;

import com.appspot.gpgbdj.CtrlPasatiempos;

public class CtrlPasatiemposTest {

	@Test
	public void test() throws IOException, ServletException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		new CtrlPasatiempos().doGet(null, response);
		Assert.assertEquals("text/plain", response.getContentType());
		Assert.assertEquals("UTF-8", response.getCharacterEncoding());
		Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
	}
}
