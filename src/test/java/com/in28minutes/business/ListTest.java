package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2);
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
	}
	
	@Test
	public void letsMockListGet() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mockList.get(0));
		assertEquals("in28Minutes", mockList.get(1));
	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		//Given
		List<String> mockList = mock(List.class);
		given(mockList.get(anyInt())).willReturn("in28Minutes");
		//When
		String firstElement = mockList.get(0);
		//Then
		assertThat(firstElement,is("in28Minutes"));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenThrow(new RuntimeException());
		mockList.get(0);
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_mixingUp() {
		List mockList = mock(List.class);
		when(mockList.subList(anyInt(), 5)).thenThrow(new RuntimeException());
		mockList.get(0);
	}

}
