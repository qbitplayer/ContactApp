package test;

import org.junit.Assert;
import org.junit.Test;

import main.ListPerson;
import main.Person;
import util.FileHelper;

public class TestListPerson {

	
	
	@Test	
	public void testContructorList(){
		
	
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
	    ListPerson list = new ListPerson(strContacts ); 
	     
		 Assert.assertEquals(strContacts.length,list.size());
		 Person person = list.get(0);  
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getEmail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress()); 
		
	}
	
	
	@Test	
	public void testAddList(){
		
		String strContactAdd= "Pablo Marmol; 0034123456789; pedro@pica.com;Marmol 47";
		
		String[] strNewList= new String[] 
				{"Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"};
		
		ListPerson list = new ListPerson(strNewList);	
		Person newPerson = new Person(strContactAdd);
		list.add(newPerson);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	@Test	
	public void testRemoveList(){
		

		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		//list.remove(0);
		
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	@Test
	public void testSort(){
		String strContact0= "Soraya García;003412415789;soraya@garcia.com;Calle Ferrer 45"; 
		String strContact1= "Lorena Porter;003412415700;Lorena@porter.com;Avenida Lopera 19"; 
		String strContact2= "Anna Gaston;003478522541;Anna@gaston.com;Riera Alta 77"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		ListPerson list = new ListPerson(strContacts);
		Person person[] = list.sort();
		
		Assert.assertEquals("Anna",person[0].getName());
		Assert.assertEquals("Gaston",person[0].getSurname());
		Assert.assertEquals("003478522541",person[0].getPhone());
		Assert.assertEquals("Anna@gaston.com",person[0].getEmail());
		Assert.assertEquals("Riera Alta 77",person[0].getAddress());
		Assert.assertEquals("Lorena",person[1].getName());
		Assert.assertEquals("Porter",person[1].getSurname());
		Assert.assertEquals("Soraya",person[2].getName());
		Assert.assertEquals("García",person[2].getSurname());
	}
	
	
	
	
}
