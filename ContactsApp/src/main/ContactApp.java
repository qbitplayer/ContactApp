package main;

import util.FileHelper;

public class ContactApp {
	
	private static final String FILE_NAME ="fileName.txt"; 

	/**
	 * Desarrolle una aplicación para guardar contactos, la aplicación debe permitir: 
			*	Adicionar un contacto
			*	Listar todos los contactos  almacenados
			*	Listar ordenados por nombre
			*	Buscar por nombre
			*	Buscar por email
			*	Editar un contacto
			*	Eliminar un contacto
		Un contacto debe tener la siguiente información:  
			*	Nombre
			*	Teléfono
			*	Email
			*   Address
			
	 * @param args
	 */
	
	public static void main(String[] args) {
	
		
		String[] strContacts = FileHelper.readFile(FILE_NAME); 
		if(strContacts==null)
			strContacts = new String[0]; 
		
		
		ListPerson list = new ListPerson(strContacts); 
		boolean exit=false; 
		
		
		
		do{
			
			UserInterface.printfMenu(); 
			
			String key = UserInterface.scannOption();
			
			switch (key) {
			
				case "a": 
					
					
					list.add(UserInterface.scannContact()); 
					FileHelper.writeFile(list.toFileFormat() , FILE_NAME); 
					
					break;
				case "r":  
					list.remove(UserInterface.scannContact()); 
						
					break;
				case "l":
					UserInterface.printList(list.getPersons()); 
					break;
					
				case "exit":
					exit = true; 
					break;
					
				default:
					break;
				}
			
		}while(!exit);  
		
		
	}
	
	
	

}
