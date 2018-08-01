package com.candykids.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CandyKidsDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInMb=10 * 1024 * 1024; //10MB
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {CandyKidsHibernateConfig.class,CandyKidsSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {CandyKidsWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		File uploadDir=new File(System.getProperty("java.io.tmpdir"));
		MultipartConfigElement multipartConfigElement=new MultipartConfigElement(uploadDir.getAbsolutePath(), maxUploadSizeInMb, maxUploadSizeInMb*2, maxUploadSizeInMb/2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}
