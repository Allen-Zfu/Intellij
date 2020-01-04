//package OOD.RelatedToMath;
//import java.util.*;
//
///*
//Main functionalities:
//1. files, directory, a directory contains files/sub-directories 文件夹里有文件 和 文件夹！！
//2. metadata (data of data) of files/directories: name, creation time, access time, modification
//    time, etc.  matadata 源数据
//    e.g.如果在ios后端打-la，就是列出有哪些文件，何时创建，access权限，上次修改时间等等
//第三条，就是要能够对于文件做编辑修改等等
//3. A FileSystem can then be modeled as a tree consisting of files/directories 每一个treenode可以是文件也可以是文件夹
//（和文件系统打交道的时候 是和path打交道 而不是通过entry到交道的）
//
//
//关键：file和directory拥有同一个祖先类
//user通过所给的path，找到的是一个对应的entry（即TreeNode）
//
//--》 关键: 通过path对文件系统对应TreeNode进行add/delete/update….不同操作
//in-Memory File System：
//1.抓住’使用Tree data structure‘模拟in-memory文件系统
//2.抓住’通过path‘的操作方法
//
//in-memory file system：文件存储在memory中
//file system ： 存储在一台机器的hard disk上
//distributed file system：存储在多台机器的hard disk上
//
//→ 随着处理数据规模的增加，OOD与system design开始融合，注意体会不同数据规模的共性与区别，以及不同的处理方法。
// */
//
////定义TreeNode （即Entry --》（包括定义需要取用的metadata）
//
///**
// * 破题思路：file system里面最重要的就是file和directory，实际上这两个是同一个类型的东西，所以他们必须要有一个
// * 共同的abstrct class : Entry去定义file和system可以共同有的field和methods
// *
// * 先定义Entry，看看需要哪些fileds和methods
// * 再分别定义file和directory，看看有哪些更加特别的fileds和methods
// * **/
//
///**最后使用FileSystem来模拟
// * 讨论要实现的最重要的功能是哪些：（和面试官来讨论哪些是最重要的）
// * 1.通过所给路径找到一个entry
// * 2.新建一个directory
// * 3.新建一个file
// * 4.delete......
// * 通过讨论结果来决定放哪些public API
// *
// */
//public abstract class Entry {
//    protected Directory parent;
//    protected long created;
//    protected long lastUpdated;
//    protected long lastAccessed;
//    protected String name;
//
//    public Entry(String n, Directory p) {
//        name = n;
//        parent=p;
//        created = System.currentTimeMillis(); // 拿到系统当前的时间作为创建时间
//    }
//
//    public boolean delete() {
//        if (parent == null) {
//            return false;
//        }
//        return parent.deleteEntry(this);
//    }
//
//    public abstract int size();
//
//    /*拿到文件路径e.g./us r/local/bin/gcc*/
//    public String getFullPath() {
//        if (parent == null) {
//            return name;
//        } else {
//            return parent.getFullPath() + "/" + name;
//        }
//    }
//
//    public long getCreation Time() {
//        return created;
//    }
//
//    public long getLastUpdatedTime() {
//        return lastUpdated;
//    }
//
//    public long getLastAccessedTime() {
//        return lastAccessed;
//    }
//
//    public void changeName(String n) {
//        name = n;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
////----------------------------------------------------------
////定义file
//public class File extends Entry {
//    private String content; // or byte[]
//    private int size;
//
//    public File(String n, Directory p, int sz) {
//        super(n, p);
//        size = sz;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public String getContents() {
//        return content;
//    }
//
//    public void setContents(String c) {
//        content = c;
//    }
//}
//
////-----------------------------------------------------------
////定义directory
//public class Directory extends Entry {
//    protected List<Entry> contents; //表现directory里面可能包括其它directory/file，所以使用entry（恰好对应n-array tree的形式）
//
////    public Directory(String n, Directory p) {
//        super(n, p);
//        contents = new ArrayList<Entry>();
//    }
//
//    protected ArrayList<Entry> getContents() {
//        return contents;
//    }
//
//    public int size() {
//        int size = 0;
//        for (Entry e : contents) {
//            size += e.size();
//        }
//        return size;
//    }
//
//    public int numberOfFiles() { //计算(#directory+#file）in one directory
//        int count = 0;
//        for (Entry e : contents) {
//            if (e instanceof Directory) {
//                count++; // Directory counts as a file
//                Directory d = (Directory) e;
//                count += d.numberOfFiles();
//            } else if (e instanceof File) {
//                count++;
//            }
//            return count;
//        }
//
//        public boolean delete Entry(Entry entry) {
//            return contents.remove(entry);
//        }
//
//        public void addEntry (Entry entry){
//            contents.add(entry);
//        }
//    }
//
//    //---------------------------------------------------------------
////建Tree，模拟in-memory file system结构
//
//    public class FileSystem {
//        private final Directory root;
//
//        public FileSystem() {
//            root = new Directory("/", null);
//        }
//
//        /**
//         * resolve a path like /foo/bar
//         */
////通过输入的path，找到该path上对应的所有entries(TreeNodes)并返回
//        private List<Entry> resolve(String path) {
//            assert path.startsWith("/"); //确认input一定是有效路径(即’/’开始)
//            String[] components = path.substring(1).split("/");
//            List<Entry> entries = new ArrayList<Entry>(components.length + 1);
//            entries.add(root);
//
//            Entry entry = root;
//            for (String component : components) {
//                if (entry = null || !(entry instanceof Directory)) {
//                    throw new IllegalArgumentException("invalid path: " + path);
//                }
//                if (!component.isEmpty()) {
//                    entry = ((Directory) entry).getChild(component);
////在directory里有entry.getchild（string str）的方程 拿到这个string名对应的directory
//// directory.getchid（string str） :
////case 1：这里如果最后一位之前出现file名，throw illegal
////case 2：最后一位的str如果是file name,那么默认在entries中添加一个null entry
////case 3:(如最后一位的str是directory name，仍然直接在enries中添加directory）
////这样对于下面的mkdir就很好理解
//
//                    entries.add(entry);
//                }
//            }
//            return entries;
//        }
//
//
//        public void mkdir(String path) {
//            List<Entry> entries = resolve(path);
////case 1：如果最后一位不是null 那么说明这个directory已经存在了,并且里面已经有file了
////case 2：如果是null 说明原path最后一位是单独file，所以entries最后一位添加的是null，此时//我们需要在最后一位make a new directory
//            if (entries.get(entries.size() - 1) != null) {
//                throw new IllegalArgumentException("Directory already exists: " + path);
//            }
//// 走到这里说明我的path split完以后 最后一位是file name   所以建立一个和file name同名的directory
//            String[] components = path.split("/");
//            final String dirName = components[components.length - 1];
//            final Directory parent = (Directory) entries.get(entries.size() - 2);
//            Directory newDir = new Directory(dirName, parent);
//            parent.addEntry(newDir); //update path,connnect parent with new dir
//        }
//
//
//        //
//        public void createFile(String path) {
//            assert !path.endsWith("/");
//            List<Entry> entries = resolve(path);
//            if (entries.get(entries.size() - 1) != null) {
//                throw new IllegalArgumentException("File already exists:" + path);
//            }
//            final String fileName = path.substring(path.lastIndexOf("/") + 1);
//            final Directory parent = (Directory) entries.get(entries.size() - 2);
//            File file = new File(fileName, parent, 0);
//            parent.addEntry(file);
//        }
//
//        public void delete(String path) {
//            // TODO: delete the file/directory with the given path
//        }
//
//        public Entry[] list(String path) { // better output?
//            // TODO: list all the immediate children of the directory specified by the given path
//            return null;
//        }
//
//        public int count() {
//            // TODO: return the total number of files/directories in the FileSystem
//        }
//    }
//}