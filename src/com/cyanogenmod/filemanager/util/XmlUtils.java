package com.cyanogenmod.filemanager.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public final class XmlUtils {

    private XmlUtils() {
    }

    public static void beginDocument(XmlPullParser parser, String firstElementName)
            throws XmlPullParserException, IOException {
        int type;
        while ((type = parser.next()) != XmlPullParser.START_TAG
                && type != XmlPullParser.END_DOCUMENT) {
        }
        if (type != XmlPullParser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }
        if (!firstElementName.equals(parser.getName())) {
            throw new XmlPullParserException(
                    "Unexpected start tag: found " + parser.getName() + ", expected " + firstElementName);
        }
    }

    public static void nextElement(XmlPullParser parser)
            throws XmlPullParserException, IOException {
        int type;
        while ((type = parser.next()) != XmlPullParser.START_TAG
                && type != XmlPullParser.END_DOCUMENT) {
        }
    }
}
