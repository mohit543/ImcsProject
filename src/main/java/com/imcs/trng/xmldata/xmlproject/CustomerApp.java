package com.imcs.trng.xmldata.xmlproject;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import training.imcs.jaxb.Customer;

public class CustomerApp {
	public static void main(String[] args) {
		
		marshall();
		//unmarshall();

	}

	static void marshall() {
		try {
			Customer customer = new Customer();
			File file = new File("D://CustomerFile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	static Customer unmarshall() {
		try {
		File file = new File("D:\\IMCS\\xmlproject\\src\\main\\resources\\xml\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.toString());
			return customer;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}
}
