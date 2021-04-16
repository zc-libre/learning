package com.zc.pattern.composite;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2021/3/31 9:46
 */
public class FileSystemNode {

    private String path;

    private boolean isFile;

    private List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        return 0;
    }

    public long countSizeOfFiles() {
        return 0;
    }

    public String getPath() {
        return  path;
    }

    public  void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size =  subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
