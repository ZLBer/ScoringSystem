function JSONToExcelConvertor(JSONData, FileName, ShowLabel) {

    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;

    var excel = '';

//设置表头
    var row = "   <Row>\n";
    for (var i = 0, l = ShowLabel.length; i < l; i++) {
        row += "    <Cell><Data ss:Type=\"String\">" + ShowLabel[i].value + '</Data></Cell>\n';
    }

//换行
    excel += row + "   </Row>\n";

//设置数据
    for (var i = 0; i < arrData.length; i++) {
        var row = "   <Row>\n";

        for(var j=0;j<arrData[i].length;j++){
            var value = arrData[i][j].value === "." ? "" : arrData[i][j].value;
            row += '    <Cell><Data ss:Type="String">' + value + '</Data></Cell>\n';
        }

        excel += row + "   </Row>\n";
    }


    var excelFile = "<?xml version=\"1.0\"?>\n" +
        "<?mso-application progid=\"Excel.Sheet\"?>\n" +
        "<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"\n" +
        " xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
        " xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n" +
        " xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"\n" +
        " xmlns:html=\"http://www.w3.org/TR/REC-html40\">\n" +
        " <DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">\n" +
        "  <Created>2006-09-16T00:00:00Z</Created>\n" +
        "  <LastSaved>2017-11-28T05:20:55Z</LastSaved>\n" +
        "  <Version>14.00</Version>\n" +
        " </DocumentProperties>\n" +
        " <OfficeDocumentSettings xmlns=\"urn:schemas-microsoft-com:office:office\">\n" +
        "  <AllowPNG/>\n" +
        "  <RemovePersonalInformation/>\n" +
        " </OfficeDocumentSettings>\n" +
        " <ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">\n" +
        "  <WindowHeight>8010</WindowHeight>\n" +
        "  <WindowWidth>14805</WindowWidth>\n" +
        "  <WindowTopX>240</WindowTopX>\n" +
        "  <WindowTopY>105</WindowTopY>\n" +
        "  <ProtectStructure>False</ProtectStructure>\n" +
        "  <ProtectWindows>False</ProtectWindows>\n" +
        " </ExcelWorkbook>\n" +
        " <Styles>\n" +
        "  <Style ss:ID=\"Default\" ss:Name=\"Normal\">\n" +
        "   <Alignment ss:Vertical=\"Bottom\"/>\n" +
        "   <Borders/>\n" +
        "   <Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"11\" ss:Color=\"#000000\"/>\n" +
        "   <Interior/>\n" +
        "   <NumberFormat/>\n" +
        "   <Protection/>\n" +
        "  </Style>\n" +
        "  <Style ss:ID=\"s16\">\n" +
        "   <NumberFormat ss:Format=\"@\"/>\n" +
        "  </Style>\n" +
        " </Styles>\n" +
        " <Worksheet ss:Name=\"Sheet1\">\n" +
        "  <Table ss:ExpandedColumnCount=\"4\" ss:ExpandedRowCount=\"3\" x:FullColumns=\"1\"\n" +
        "   x:FullRows=\"1\" ss:StyleID=\"s16\" ss:DefaultColumnWidth=\"54\"\n" +
        "   ss:DefaultRowHeight=\"13.5\">\n" +
        "   <Column ss:StyleID=\"s16\" ss:Width=\"76.5\"/>\n";
    excelFile += excel;
    excelFile += "</Table>\n" +
        "  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">\n" +
        "   <PageSetup>\n" +
        "    <Header x:Margin=\"0.3\"/>\n" +
        "    <Footer x:Margin=\"0.3\"/>\n" +
        "    <PageMargins x:Bottom=\"0.75\" x:Left=\"0.7\" x:Right=\"0.7\" x:Top=\"0.75\"/>\n" +
        "   </PageSetup>\n" +
        "   <Print>\n" +
        "    <ValidPrinterInfo/>\n" +
        "    <PaperSizeIndex>9</PaperSizeIndex>\n" +
        "    <HorizontalResolution>600</HorizontalResolution>\n" +
        "    <VerticalResolution>600</VerticalResolution>\n" +
        "   </Print>\n" +
        "   <Selected/>\n" +
        "   <Panes>\n" +
        "    <Pane>\n" +
        "     <Number>3</Number>\n" +
        "     <ActiveRow>7</ActiveRow>\n" +
        "     <ActiveCol>3</ActiveCol>\n" +
        "    </Pane>\n" +
        "   </Panes>\n" +
        "   <ProtectObjects>False</ProtectObjects>\n" +
        "   <ProtectScenarios>False</ProtectScenarios>\n" +
        "  </WorksheetOptions>\n" +
        " </Worksheet>\n" +
        " <Worksheet ss:Name=\"Sheet2\">\n" +
        "  <Table ss:ExpandedColumnCount=\"1\" ss:ExpandedRowCount=\"1\" x:FullColumns=\"1\"\n" +
        "   x:FullRows=\"1\" ss:DefaultColumnWidth=\"54\" ss:DefaultRowHeight=\"13.5\">\n" +
        "  </Table>\n" +
        "  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">\n" +
        "   <PageSetup>\n" +
        "    <Header x:Margin=\"0.3\"/>\n" +
        "    <Footer x:Margin=\"0.3\"/>\n" +
        "    <PageMargins x:Bottom=\"0.75\" x:Left=\"0.7\" x:Right=\"0.7\" x:Top=\"0.75\"/>\n" +
        "   </PageSetup>\n" +
        "   <ProtectObjects>False</ProtectObjects>\n" +
        "   <ProtectScenarios>False</ProtectScenarios>\n" +
        "  </WorksheetOptions>\n" +
        " </Worksheet>\n" +
        " <Worksheet ss:Name=\"Sheet3\">\n" +
        "  <Table ss:ExpandedColumnCount=\"1\" ss:ExpandedRowCount=\"1\" x:FullColumns=\"1\"\n" +
        "   x:FullRows=\"1\" ss:DefaultColumnWidth=\"54\" ss:DefaultRowHeight=\"13.5\">\n" +
        "  </Table>\n" +
        "  <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">\n" +
        "   <PageSetup>\n" +
        "    <Header x:Margin=\"0.3\"/>\n" +
        "    <Footer x:Margin=\"0.3\"/>\n" +
        "    <PageMargins x:Bottom=\"0.75\" x:Left=\"0.7\" x:Right=\"0.7\" x:Top=\"0.75\"/>\n" +
        "   </PageSetup>\n" +
        "   <ProtectObjects>False</ProtectObjects>\n" +
        "   <ProtectScenarios>False</ProtectScenarios>\n" +
        "  </WorksheetOptions>\n" +
        " </Worksheet>\n" +
        "</Workbook>";


    var uri =  'data:application/vnd.ms-excel;charset=utf-8,' +  encodeURIComponent(excelFile);

    var link = document.createElement("a");
    link.href = uri;

    link.style = "visibility:hidden";
    link.download = FileName + ".xls";

    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
var JSON_DATA = {
    "title":[],
    "data":[]
};