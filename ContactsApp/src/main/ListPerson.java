package main;

import java.util.Arrays;

public class ListPerson {
	
	private Person[] contacts;

	
	public ListPerson(String[] strContacts){
		iniContact(strContacts); 
	}
	
	private void iniContact(String[] strContacts) {
		contacts = new Person[strContacts.length]; 
		  
		  for(int i=0; i<strContacts.length; i++){
			  String contactFileFormat = strContacts [i]; 
			  Person contact = new Person(contactFileFormat);
		      //add(contact); 
			  contacts[i] = contact;  
		  }
	}


	/**
	 * Retorna el numero de personas que contiene
	 * @return
	 */
	public int size() {
		return contacts.length;
	}

	/**
	 * Obtiene la persona que tiene el index i 
	 * @param i
	 * @return
	 */
	public Person get(int i) {
		return contacts[i];
	}
	
	/** Sobre escribe una persona de la lista en el index dado por index 
	 * @param person
	 * @param index
	 */
	public void set(Person person, int index){
		if(index< 0 || index >= contacts.length)
			throw new RuntimeException("Indice fuera de rango");  
		
		contacts[index]=person; 
	}
	

	/**
	 * Retorna el index del objeto person 
	 * @param person
	 * @return
	 */
	public int indexOf(Person person){
		int index = -1; 
		for(int i=0; i<contacts.length; i++){
			if(contacts[i].equals(person)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}

	/**
	 * Adiciona una persona al alrreglo interno de personas. 
	 * Se adiciona en la ultima posicion
	 * @param contact
	 */
	public void add(Person contact) {			
		Person[] copyContacts = new Person[contacts.length+1];	
		for(int i=0;i<contacts.length;i++){
			copyContacts[i]=contacts[i];
		}
		copyContacts[contacts.length]=contact;		
		
		contacts = copyContacts;	
	}
	
	/**
	 * Elimina una persona del la lista
	 * @param person
	 */
	public void remove(Person person) {
		remove(indexOf(person));   
	}
	
	public void remove(int index) {
		if(index< 0 || index >= contacts.length)
			return; 
			
		
	}
	
	/**
	 * Retorna todas las personas que coontengan strString en su campo name
	 * @return
	 */
	public Person[] findByName(String strName){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		// for each 
	
		for(Person person: contacts){
			String name = person.getName().toLowerCase(); 
			if(name.startsWith(strName.toLowerCase()))
				array[counter++]=person; 
		}
		
		Person personsWithEmail[] = new Person[counter];  
		
		for(int i=0,k=0; i<contacts.length; i++){
			if(contacts[i].getName().startsWith(strName))
				personsWithEmail[k++]=contacts[i];
		}
		
	 return personsWithEmail;
	}

	/**
	 * Retorna todas las personas que contengan strMail en su campo email
	 * @return
	 */
	public Person[] findByEmail(String strMail){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		// for each 
	
		for(Person person: contacts){
			String email = person.getEmail().toLowerCase(); 
			if(email.startsWith(strMail.toLowerCase()))
				array[counter++]=person; 
		}
		
		Person personsWithEmail[] = new Person[counter];  
		
		for(int i=0,k=0; i<contacts.length; i++){
			if(contacts[i].getEmail().startsWith(strMail))
				personsWithEmail[k++]=contacts[i];
		}
		
	 return personsWithEmail;
	}
	
	

	/**
	 * Retorna una copia de la lista ordenada alfabeticamente
	 * @return
	 */
	public Person[] sort(){
		String sortNames[] = new String[contacts.length];
		Person sortContacts[] = new Person[contacts.length];
		
		for(int i=0;i<contacts.length;i++){
			sortNames[i] = contacts[i].getFullName();
		}
		Arrays.sort(sortNames);
		int control=0;
		for(int i=0;i<sortNames.length;i++){
			for(int j=0;j<contacts.length;j++){
				if(sortNames[i].equals(contacts[j].getFullName())){
					sortContacts[control++]=contacts[j];
				}
			}
		}
		
		return sortContacts;
	}
	
	private Person findByFullName(String fullName) {
		 Person personFound =null;  
		// TODO Auto-generated method stub	
		for(int i=0; i< contacts.length; i++){
			if(contacts[i].getFullName().equals(fullName)){
				personFound = contacts[i]; 
				break; 
			}
		}
		return personFound;
	}
	
	
	
	public Person[] getContacts(){
		return contacts; 
	}
	

	public Person[] getPersons(){
		Person array[] = new Person[contacts.length];  	
		for(int i=0; i<contacts.length; i++){
			array[i]=contacts[i]; 
		}	
	 return array; 
	}
	
	
	public String[] toFileFormat(){		
		String array[] = new String[contacts.length];  	
		for(int i=0; i<contacts.length; i++){
			array[i]=contacts[i].toFileFormat(); 
		}	
		return array; 
	}
	
	
}
