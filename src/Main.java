import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//interface Entry {
//	String getName();
//
//	int getSize();
//}

// ファイル
class File {
	// ファイル名
	private String name;

	// ファイルサイズ
	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}

// フォルダ
class Folder {
	private String name;

	// フォルダには複数のフォルダを格納できる
	private List<Folder> folders = new LinkedList<>();

	// フォルダには複数のファイルを格納できる
	private List<File> files = new LinkedList<>();

	public Folder(String name) {
		this.name = name;
	}

	public void addFile(File file) {
		files.add(file);
	}

	public void addFolder(Folder folder) {
		folders.add(folder);
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return 0; // TODO 再帰的にサイズ合計を求める
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

public class Main {
	public static void main(String[] args) {
		Folder folder1 = new Folder("c:\\");
		Folder folder2 = new Folder("Windows");
		Folder folder3 = new Folder("Users");

		folder1.addFolder(folder2);
		folder1.addFolder(folder3);

		File file = new File("explorer.exe", 1234);
		folder2.addFile(file);

		System.out.println(folder1);
	}
}
