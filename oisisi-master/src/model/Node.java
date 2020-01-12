package model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String name;
	Node parent;
	List<Node> children;

	public Node() {
		this.children = new ArrayList<Node>();
	}

	public Node(String name, Node parent) {
		this();
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public String toString() {
		return this.name;
	}

	// ================================
	// Manipulacija stablom
	public boolean isRoot() {
		return this.parent == null;
	}

	public void addChildren(Node newChild) {
		// TODO: eventualne provere da li je dodavanja moguce
		// dodavanje cvora
		this.children.add(newChild);
		newChild.setParent(this);
		System.out.printf("Dodat cvor: %s kao dete cvora: %s, koji ima: %d dece.\n", newChild.getName(), this.name,
				this.children.size());
	}

	public void removeChild(Node child) {
		// TODO: eventualne provere da li je brisanje moguce
		this.children.remove(child);
		child.setParent(null);
		System.out.printf("Obrisan cvor: %s od cvora: %s, koji ima: %d dece.\n", child.getName(), this.name,
				this.children.size());
	}
	
	public void removeFromParent() {
		// pozovemo parenta da nas ukloni
		this.parent.removeChild(this);
	}

	public boolean isLeaf() {
		// da li je list u modelu, ne odnosi se ne JTreeModel
		return this.children.isEmpty();
	}

}
