package com.db.auction;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.omg.CORBA.portable.OutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageFTP {
    public static void uploadImage(String filePath, String remoteFile) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("ec2-13-209-35-117.ap-northeast-2.compute.amazonaws.com");
        int reply = ftpClient.getReplyCode();
        if(!FTPReply.isPositiveCompletion(reply)){
            ftpClient.disconnect();
            throw new IOException();
        }
        ftpClient.login("auction", "konkuk14*4");

        InputStream fileStream = new FileInputStream(new File(filePath));

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.enterLocalPassiveMode();
        ftpClient.storeFile(remoteFile, fileStream);
        ftpClient.disconnect();
    }

    public static ImageIcon downloadImage(String remoteFile) throws IOException{
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("ec2-13-209-35-117.ap-northeast-2.compute.amazonaws.com");
        int reply = ftpClient.getReplyCode();
        if(!FTPReply.isPositiveCompletion(reply)){
            ftpClient.disconnect();
            throw new IOException();
        }
        ftpClient.login("auction", "konkuk14*4");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.enterLocalPassiveMode();
        ftpClient.retrieveFile(remoteFile, bos);

        Image origImageIcon = new ImageIcon(bos.toByteArray()).getImage().getScaledInstance(335, 150, Image.SCALE_FAST);
        return new ImageIcon(origImageIcon);
    }
}
