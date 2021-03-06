package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;
import org.zerock.service.TxService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Setter(onMethod_={@Autowired})
	private TimeMapper mapper;


	@Setter(onMethod_={@Autowired})
	private TxService service;
	
	@Test
	public void testTx() {

		String str = "�ڵ������� 3�� ������ �ɶ󽺸� �ڵ������� 3�� ������ �ɶ󽺸� �ڵ����� �ɶ󽺸� �ڵ����� �ɶ󽺸�  ";
		
		service.insertAll(str);
		
	}
	@Test
	public void testTime() {
		
		log.info(mapper.getTime());
	}
	
}
