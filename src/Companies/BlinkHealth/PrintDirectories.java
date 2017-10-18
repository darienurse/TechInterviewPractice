package Companies.BlinkHealth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Darien on 10/18/2017.
 */

public class PrintDirectories {

//		Given a list of paths
//		/home/patient/care/staff
//		/home/patient/care/member
//		/home/home/location/time
//		/home/home/location
//		/drug/tylenol/side-effect
//		/drug/tylenol/price
//		/drug/ibuprofen/side-effect
//		/drug/ibuprofen/price
//
//		print out structure
//
//		home
//			patient
//				care
//					staff
//					member
//			home
//				location
//					time
//		drug
//			tylenol
//				side-effect
//				price
//			ibuprofen
//				side-effect
//				price

	final static List<String> input =Arrays.asList(
			"/home/patient/care/staff",
			"/home/patient/care/member",
			"/home/home/location/time",
			"/home/home/location",
			"/drug/tylenol/side-effect",
			"/drug/tylenol/price",
			"/drug/ibuprofen/side-effect",
			"/drug/ibuprofen/price"); //declared with default values
	public static void main(String [] args) {
		List<Node> heads = createHeads(input);
		printChildren(heads, 0);
	}


	private static void printChildren(List<Node> children, int depth){
		if(!children.isEmpty()){
			String tabs = new String(new char[depth]).replace("\0", "	");
			for(Node n : children){
				System.out.print(tabs + n + "\n");
				printChildren(n.mChildren, depth+1);
			}
		}
	}
	private static List<Node> createHeads(final List<String> input) {
		final List<Node> results = new ArrayList<Node>();
		for(String s : input){
			String[] sections = s.split("/");
			Node head = new Node(sections[1]);
			if(results.contains(head)){
				head = results.get(results.indexOf(head));
			} else {
				results.add(head);
			}
			buildChildren(head, 2, sections);
		}
		return results;
	}

	private static void buildChildren(final Node parent, final int index, final String[] sections) {
		if(index < sections.length){
			final Node child = new Node(sections[index]);
			if(parent.hasChild(child)){
				buildChildren(parent.getChild(child), index+1, sections);
			} else{
				parent.addChild(child);
				buildChildren(child, index+1, sections);
			}
		}
	}

	private static class Node{
		private final String mData;
		private final List<Node> mChildren = new ArrayList<Node>();

		public Node(final String data) {
			mData = data;
		}

		private void addChild(Node n){
			mChildren.add(n);
		}

		public String getData() {
			return mData;
		}

		public boolean hasChild(Node n){
			return mChildren.contains(n);
		}

		public Node getChild(Node n){
			return mChildren.get(mChildren.indexOf(n));
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			final Node node = (Node) o;

			return mData.equals(node.mData);

		}

		@Override
		public String toString() {
			return mData;
		}

		@Override
		public int hashCode() {
			return mData.hashCode();
		}
	}
}
