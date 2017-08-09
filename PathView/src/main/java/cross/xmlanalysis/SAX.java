package cross.xmlanalysis;

import android.text.TextUtils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import cross.model.PathArea;
import cross.util.SvgPathToAndroidPath;

/**
 * Author ChengYuanhang
 * Date 2017/3/10
 * Time 18:26
 */
public class SAX {
    public List<PathArea> readXML(InputStream is) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(is, handler);
            return handler.getPathAreas();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    class SAXHandler extends DefaultHandler {
        private List<PathArea> pathAreas;
        private PathArea area;
        private SvgPathToAndroidPath lParser;

        public List<PathArea> getPathAreas() {
            return pathAreas;
        }

        public void setPathAreas(List<PathArea> pathAreas) {
            this.pathAreas = pathAreas;
        }

        //遍历xml的开始标签
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if (qName.equals("path")) {
                area = new PathArea();
                area.setAreaName(attributes.getValue("android:name"));
                String stroke = attributes.getValue("android:strokeColor");
                if (!TextUtils.isEmpty(stroke)) {
                    area.setStrokeColor(stroke);
                } else {
                    area.setStrokeColor(null);
                }
                String fill = attributes.getValue("android:fillColor");
                if (!TextUtils.isEmpty(fill)) {
                    area.setFillColor(fill);
                } else {
                    area.setFillColor(null);
                }

                String pathData = attributes.getValue("android:pathData");
                if (!TextUtils.isEmpty(pathData)) {
                    area.setPath(lParser.parser(pathData));
                }
                double fillAlpha = 1;
                try {
                    fillAlpha = Double.parseDouble(attributes.getValue("android:fillAlpha"));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//
                    area.setFillAlpha(fillAlpha);
                }
                double strokeAlpha = 1;
                try {

                    strokeAlpha = Double.parseDouble(attributes.getValue("android:strokeAlpha"));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    area.setStrokeAlpha(strokeAlpha);
                }
                double strokeWidth = 0;
                String sw = attributes.getValue("android:strokeWidth");
                if (!TextUtils.isEmpty(sw)) {
                    try {
                        strokeWidth = Double.parseDouble(attributes.getValue("android:strokeWidth"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (strokeWidth >= 0 && strokeWidth < 1) {
                            strokeWidth = 1;
                        }
                        area.setStrokeWidth((int)strokeWidth);
                    }
                }else {
                    area.setStrokeWidth((int)strokeWidth);
                }

            }
        }

        //遍历xml的结束标签
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if ("path".equals(qName)) {
                pathAreas.add(area);
            }
        }

        //开始解析
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            pathAreas = new ArrayList<>();
            lParser = new SvgPathToAndroidPath();
        }
        //结束解析

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }
    }
}
