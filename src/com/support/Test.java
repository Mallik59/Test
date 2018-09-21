package com.support;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Test {
	public static void main(String[] argv) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//factory.setValidating(true);
		//factory.setExpandEntityReferences(false);
		Document doc = factory.newDocumentBuilder().parse(new File("test.xml"));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xpath.compile("//root/*/dummy");
		NodeList list = (NodeList) expression.evaluate(
		  doc, XPathConstants.NODESET);
		
		//NodeList list = doc.getElementsByTagName("company");
		for (int i = 0; i < list.getLength(); i++){
				Element n = (Element) list.item(i);
				//
				for (int j = 0; j < n.getChildNodes().getLength(); j++) {
					System.out.println(n.getChildNodes().item(j));
				}
				Element np = (Element)n.getParentNode();
				System.out.println("==================>"+np.getElementsByTagName("dummy").item(0).getNextSibling().getNodeValue());
				NodeList nlist = n.getElementsByTagName("test");
				System.out.println(nlist.getLength());
				Node ln = n.getLastChild();
				System.out.println(ln instanceof Text);
				n.removeChild(ln);
				System.out.println(n.getTextContent());
		}

	}
}
