//package com.itheima;
//
//
//import java.nio.charset.Charset;
//import java.util.Iterator;
//import java.util.List;
//import java.util.TreeSet;
//
//import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;
//
//public final class MyInterceptor implements Interceptor {
//    private static final String APPKEY = "389885588s0648fa";
//    private static final String APPSECRET = "56E39A1658455588885690425C0FD16055A21676";
//    private static final Charset ChartSet_UTF8 = Charset.forName("UTF-8");
//    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
//
//    public MyInterceptor() {
//    }
//
//    static {
//    }
//
//    public Response intercept(Interceptor.Chain chain) {
//        boolean z;
//        String str;
//        Request.Builder newBuilder;
//        Request.Builder addHeader;
//        Request.Builder addHeader2;
//        Request.Builder newBuilder2;
//        Request.Builder addHeader3;
//        Request.Builder addHeader4;
//        Request.Builder addHeader5;
//        String str2;
//        String str3;
//        boolean z2;
//        String str4;
//        String str5;
//        String str6;
//        String str7;
//        Set queryParameterNames;
//        Interceptor.Chain chain2 = chain;
//        Intrinsics.checkParameterIsNotNull(chain2, "chain");
//        Request request = chain.request();
//        // 注意，TreeSet是有序集合，且默认为正序排列，即{a, b, c, d [,...]}
//        TreeSet treeSet = new TreeSet();
//        Request request2 = null;
//        HttpUrl url = request != null ? request.url() : null;
//        if (!(url == null || (queryParameterNames = url.queryParameterNames()) == null)) {
//            treeSet.addAll(queryParameterNames);
//        }
//
//        // 待签名字符串
//        StringBuilder sb = new StringBuilder();
//        Iterator it = treeSet.iterator();
//        // 开始迭代所有请求参数
//        while (true) {
//            z = false;
//            if (!it.hasNext()) {
//                break;
//            }
//            // str8 为参数名
//            String str8 = (String) it.next();
//            // 获取参数名对应的值
//            List queryParameterValues = url != null ? url.queryParameterValues(str8) : null;
//            if (queryParameterValues != null && (true ^ queryParameterValues.isEmpty())) {
//                // 参数值非空
//                // 取参数值列表第一个
//                String str9 = (String) (url != null ? url.queryParameterValues(str8) : null).get(0);
//                if (!TextUtils.isEmpty(str9)) {
//                    // str8 参数名， str9 参数值
//                    // str9非空，追加str8 str9在sb之后
//                    sb.append(str8);
//                    sb.append(str9);
//                }
//            }
//        }
//        // 追加APPKEY
//        sb.append("389885588s0648fa");
//        // 追加APPSECRET
//        sb.append("56E39A1658455588885690425C0FD16055A21676");
//        if (request.body() != null) {
//            BufferedSink buffer = new Buffer();
//            RequestBody body = request.body();
//            if (body != null) {
//                body.writeTo(buffer);
//            }
//            Charset charset = ChartSet_UTF8;
//            RequestBody body2 = request.body();
//            MediaType contentType = body2 != null ? body2.contentType() : null;
//            if (contentType != null) {
//                // 追加请求体
//                sb.append(buffer.readString(contentType.charset(charset)));
//            }
//        }
//        // 同sb
//        String sb2 = sb.toString();
//        Intrinsics.checkExpressionValueIsNotNull(sb2, "signStr.toString()");
//        CharSequence charSequence = sb2;
//        if (!(charSequence == null || charSequence.length() == 0)) {
//            // 本级语句块替换一些字符为空字符，即删除部分字符，这将导致参与MD5运算的字符串有所差异
//            // z2 为是否发生过替换操作
//            // 删除空格
//            if (StringsKt.contains$default(charSequence, " ", false, 2, (Object) null)) {
//                str3 = StringsKt.replace$default(sb2, " ", "", false, 4, (Object) null);
//                z2 = true;
//            } else {
//                str3 = sb2;
//                z2 = false;
//            }
//            // 删除~
//            if (StringsKt.contains$default(str3, "~", false, 2, (Object) null)) {
//                str4 = StringsKt.replace$default(str3, "~", "", false, 4, (Object) null);
//                z2 = true;
//            } else {
//                str4 = str3;
//            }
//            // 删除!
//            if (StringsKt.contains$default(str4, "!", false, 2, (Object) null)) {
//                str5 = StringsKt.replace$default(str4, "!", "", false, 4, (Object) null);
//                z2 = true;
//            } else {
//                str5 = str4;
//            }
//            // 删除(
//            if (StringsKt.contains$default(str5, "(", false, 2, (Object) null)) {
//                str6 = StringsKt.replace$default(str5, "(", "", false, 4, (Object) null);
//                z2 = true;
//            } else {
//                str6 = str5;
//            }
//            // 删除)
//            if (StringsKt.contains$default(str6, ")", false, 2, (Object) null)) {
//                str7 = StringsKt.replace$default(str6, ")", "", false, 4, (Object) null);
//                z2 = true;
//            } else {
//                str7 = str6;
//            }
//            // 删除'
//            if (StringsKt.contains$default(str7, "'", false, 2, (Object) null)) {
//                sb2 = StringsKt.replace$default(str7, "'", "", false, 4, (Object) null);
//                z = true;
//            } else {
//                z = z2;
//                sb2 = str7;
//            }
//            if (z) {
//                sb2 = URLEncoder.encode(sb2, "utf-8");
//                Intrinsics.checkExpressionValueIsNotNull(sb2, "URLEncoder.encode(dealStr,\"utf-8\")");
//            }
//        }
//        if (z) {
//            StringBuilder sb3 = new StringBuilder();
//            // 使用替换结果 sb2 计算MD5
//            String encodeByMD5 = MD5Digest.Companion.encodeByMD5(sb2);
//            if (encodeByMD5 == null) {
//                str2 = null;
//            } else if (encodeByMD5 != null) {
//                // 转换为大写
//                str2 = encodeByMD5.toUpperCase();
//                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).toUpperCase()");
//            } else {
//                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
//            }
//            sb3.append(str2);
//            // MD5追加编码
//            sb3.append("encodeutf8");
//            str = sb3.toString();
//        } else {
//            MD5Digest.Companion companion = MD5Digest.Companion;
//            // 没有发生替换，使用sb
//            String sb4 = sb.toString();
//            Intrinsics.checkExpressionValueIsNotNull(sb4, "signStr.toString()");
//            // 使用sb计算MD5
//            String encodeByMD52 = companion.encodeByMD5(sb4);
//            if (encodeByMD52 == null) {
//                str = null;
//            } else if (encodeByMD52 != null) {
//                // 转换为大写
//                str = encodeByMD52.toUpperCase();  // 大写
//                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toUpperCase()");
//            } else {
//                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
//            }
//        }
//        try {
//            User user = (User) new PreUtil("sp_name_user").getValue("sp_user",
//                    Reflection.getOrCreateKotlinClass(User.class), (Object) null);
//            if (user != null) {
//                OauthTokenBean oauthToken = user.getOauthToken();
//                String token = oauthToken != null ? oauthToken.getToken() : null;
//                Request request3 = chain.request();
//                if (!(request3 == null || (newBuilder2 = request3.newBuilder()) == null
//                        || (addHeader3 = newBuilder2.addHeader("token", token)) == null
//                        || (addHeader4 = addHeader3.addHeader("appKey", "389885588s0648fa")) == null
//                        || (addHeader5 = addHeader4.addHeader("sign", str)) == null) // 添加签名至头部
//                ) {
//                    request2 = addHeader5.build();
//                }
//            } else {
//                Request request4 = chain.request();
//                if (!(request4 == null || (newBuilder = request4.newBuilder()) == null
//                        || (addHeader = newBuilder.addHeader("appKey", "389885588s0648fa")) == null
//                        || (addHeader2 = addHeader.addHeader("sign", str)) == null)) {
//                    request2 = addHeader2.build();
//                }
//            }
//            Response proceed = chain2.proceed(request2);
//            if (proceed == null) {
//                Intrinsics.throwNpe();
//            }
//            return proceed;
//        } catch (Exception e) {
//            e.printStackTrace();
//            Response proceed2 = chain2.proceed(request);
//            if (proceed2 == null) {
//                Intrinsics.throwNpe();
//            }
//            return proceed2;
//        }
//    }
//}