<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<html:form action="/FileUpload" method="post" enctype="multipart/form-data">
        <table>
        <tr>
            <td align="center" colspan="2">
                        <font size="4">
                       آپلود فایل
                        </font>
            </td>
        </tr>        
        
        <tr>

          <td align="right">

            نام فایل

          </td>

          <td align="left">

            <html:file property="theFile"/> 

          </td>

        </tr>
                <tr>

          <td align="center" colspan="2">

            <html:submit>
                بارگذاری
            </html:submit>

          </td>

        </tr>

  </table> 

        </html:form>
