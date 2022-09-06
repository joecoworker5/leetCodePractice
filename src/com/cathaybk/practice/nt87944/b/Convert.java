package com.cathaybk.practice.nt87944.b;

public class Convert {
    public static void main(String[] args) {

        String[] key = new String[] { "CustNo", "IdType", "IdNo", "ChiName", "EngName", "BirthType", "CustType",
                "UsaTaxNo", "DocuStatus", "DocuSignDate", "DocuExpiryDate", "AgreeDocu", "UncorpType", "EmpNo", "EmpMnDate", "CorpStatus",
                "EmpName", "SysMnDate", "SysBalFlag", "DocuKeepBr" };
        Integer[] lengths = new Integer[]  { 17, 2, 11, 80, 80, 1, 2, 9, 1, 8, 8, 1, 2, 5, 8, 1, 12, 8, 1, 4 };
        for (int i = 0; i < key.length; i++) {
            String temp = "";
            int length = lengths[i];
            //            if (!"DUMMY".equals(key[i]) || !"ToAccount".equals(key[i])) {
            if (!"DUMMY".equals(key[i])) {
                //            if (key[i] != null) {
                System.out.println("body.put(\"" + key[i] + "\", new String(receiveBytes, index, " + length + ", encoding));");
            } else {
                temp = "// DUMMY[" + length + "]";
            }
            System.out.println("index += " + length + "; " + temp);
        }

        //        for (int i = 2; i < INPUT_FIELDS.length; i++) {
        //            switch (INPUT_TYPES[i]) {
        //                case "x":
        //                    System.out.println("putByteDataToStream(bufferOutStream, rq.optString(\"" + INPUT_FIELDS[i] + "\", String.format(\"%"
        //                            + INPUT_LENGTHS[i] + "s\", \"\")), " + INPUT_LENGTHS[i] + ", encoding);");
        //                    break;
        //                case "9":
        //                    System.out.println("putByteDataToStream(bufferOutStream, formatUtil.iniFormatFNSAmountWithNoSign(rq.optString(\""
        //                            + INPUT_FIELDS[i] + "\"), " + INPUT_LENGTHS[i] + "), " + INPUT_LENGTHS[i] + ", encoding);");
        //                    break;
        //                case "9s":
        //                    System.out.println("putByteDataToStream(bufferOutStream, formatUtil.iniFormatFNSAmountWithSign(rq.optString(\""
        //                            + INPUT_FIELDS[i] + "\"), " + (INPUT_LENGTHS[i] - 1) + "), " + INPUT_LENGTHS[i] + ", encoding);");
        //                    break;
        //                default:
        //                    System.out.println("putByteDataToStream(bufferOutStream, String.format(\"%" + INPUT_LENGTHS[i] + "s\", \"\"), "
        //                            + INPUT_LENGTHS[i] + ", encoding);");
        //            }
        //        }

    }
}
