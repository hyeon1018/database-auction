package com.db.auction.gui;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageFTP {
    public static void UploadImage(String filePath, String remoteFile) throws IOException {
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

}
