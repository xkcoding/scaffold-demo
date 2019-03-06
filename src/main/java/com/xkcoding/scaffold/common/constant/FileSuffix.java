package com.xkcoding.scaffold.common.constant;

import lombok.Getter;

/**
 * <p>
 * 常见文件后缀类型枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.constant
 * @description： 常见文件后缀类型枚举
 * @author: yangkai.shen
 * @date: Created in 2018/8/6 下午4:45
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Getter
public enum FileSuffix {
    /**
     * JPEG (jpg)
     */
    JPG(".jpg"),

    /**
     * PNG (png)
     */
    PNG(".png"),

    /**
     * GIF (gif)
     */
    GIF(".gif"),

    /**
     * TIFF (tif)
     */
    TIFF(".tif"),

    /**
     * 位图(bmp)
     */
    BMP(".bmp"),

    /**
     * CAD (dwg)
     */
    CAD(".dwg"),

    /**
     * HTML (html)
     */
    HTML(".html"),

    /**
     * HTM (htm)
     */
    HTM(".htm"),

    /**
     * css
     */
    CSS(".css"),

    /**
     * js
     */
    JS(".js"),

    /**
     * json
     */
    JSON(".json"),

    /**
     * Rich Text Format (rtf)
     */
    RTF(".rtf"),

    /**
     * Photoshop (psd)
     */
    PSD(".psd"),

    /**
     * Email [Outlook Express 6] (eml)
     */
    EML(".eml"),

    /**
     * doc文件
     */
    DOC(".doc"),

    /**
     * docx文件
     */
    DOCX(".docx"),

    /**
     * Visio 绘图
     */
    VSD(".vsd"),

    /**
     * MS Access (mdb)
     */
    MDB(".mdb"),

    /**
     * Adobe Acrobat (pdf)
     */
    PDF(".pdf"),

    /**
     * rmvb/rm相同
     */
    RMVB(".rmvb"),

    /**
     * flv与f4v相同
     */
    FLV(".flv"),

    /**
     * mp4
     */
    MP4(".mp4"),

    /**
     * mp3
     */
    MP3(".mp3"),

    /**
     * mpg
     */
    MPG(".mpg"),

    /**
     * wmv与asf相同
     */
    WMV(".wmv"),

    /**
     * Wave (wav)
     */
    WAV(".wav"),

    /**
     * avi
     */
    AVI(".avi"),

    /**
     * MIDI(mid)
     */
    MID(".mid"),

    /**
     * WinRAR
     */
    RAR(".rar"),

    /**
     * ini
     */
    INI(".ini"),

    /**
     * jar
     */
    JAR(".jar"),

    /**
     * xls文件
     */
    XLS(".xls"),

    /**
     * xlsx文件
     */
    XLSX(".xlsx"),

    /**
     * zip 压缩文件
     */
    ZIP(".zip"),

    /**
     * 可执行文件
     */
    EXE(".exe"),

    /**
     * jsp文件
     */
    JSP(".jsp"),

    /**
     * MF文件
     */
    MF(".mf"),

    /**
     * xml文件
     */
    XML(".xml"),

    /**
     * sql文件
     */
    SQL(".sql"),

    /**
     * java文件
     */
    JAVA(".java"),

    /**
     * bat文件
     */
    BAT(".bat"),

    /**
     * gz文件
     */
    GZ(".gz"),

    /**
     * properties文件
     */
    PROPERTIES(".properties"),

    /**
     * class文件
     */
    CLASS(".class"),

    /**
     * chm文件
     */
    CHM(".chm"),

    /**
     * mxp文件
     */
    MXP(".mxp"),

    /**
     * WPS文字wps、表格et、演示dps都是一样的
     */
    WPS(".wps"),

    /**
     * torrent文件
     */
    TORRENT(".torrent"),

    /**
     * Quicktime(mov)
     */
    MOV(".mov"),

    /**
     * WordPerfect (wpd)
     */
    WPD(".wpd"),

    /**
     * Outlook Express (dbx)
     */
    DBX(".dbx"),

    /**
     * Outlook (pst)
     */
    PST(".pst"),

    /**
     * Quicken (qdf)
     */
    QDF(".qdf"),

    /**
     * Windows Password (pwl)
     */
    PWL(".pwl"),

    /**
     * Real Audio(ram)
     */
    RAM(".ram");

    private String value;

    FileSuffix(String value) {
        this.value = value;
    }

}
