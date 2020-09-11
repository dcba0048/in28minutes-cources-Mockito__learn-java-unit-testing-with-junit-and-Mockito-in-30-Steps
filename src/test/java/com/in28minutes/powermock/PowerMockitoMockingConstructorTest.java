package com.in28minutes.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.in28minutes.data.api.TodoService;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class PowerMockitoMockingConstructorTest {
	
	/*@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();*/  
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Mock
	ArrayList mockList;
	
	/*@Captor
	ArgumentCaptor<String> stringArgumentCaptor;*/
	
	@Test
	public void testBadNames() throws Exception {
	
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		when(mockList.size()).thenReturn(10);
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		assertEquals(10, size);
	}
	
}
