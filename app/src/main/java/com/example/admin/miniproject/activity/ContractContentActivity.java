package com.example.admin.miniproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.miniproject.R;

/**
 * Created by hanking on 2018/9/9.
 * Copyright (c) 2018 Xunlei. All rights reserved.
 *
 * @author hanking
 */
public class ContractContentActivity extends AppCompatActivity {
    private TextView content;
    private String contractContent = "";
    private int type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contract_content_activity);
        initView();
        Intent intent = getIntent();
        type = intent.getIntExtra("more", 1);
        switch (type) {
            case 1:
                contractContent = "合同（或合约），是双方当事人基于意思表示合致而成立的法律行为，为私法自治的主要表现。一般而言，合同是指私法上的法律行为，可分为债权合同（例如买卖）、物权合同（例如所有权移转登记）及身份合同（例如结婚）等，不过在公法上也可能存在合同关系。在民法上，狭义的合同（即债权合同）为债之发生的原因之一，而一般仅称合同时所指称者也多属债权合同。合同行为并不等于“合同书”，一份合同书中可能包含不只一个合同行为；合同行为也不以做成书面为必要，合同原则上为诺成且不要物的法律行为，只有在例外情形，基于特殊考量（例如公益）时法律会明文要求。";
                break;
            case 2:
                contractContent = "合同（或合约），是双方当事人基于意思表示合致而成立的法律行为，为私法自治的主要表现。一般而言，合同是指私法上的法律行为，可分为债权合同（例如买卖）、物权合同（例如所有权移转登记）及身份合同（例如结婚）等，不过在公法上也可能存在合同关系。在民法上，狭义的合同（即债权合同）为债之发生的原因之一，而一般仅称合同时所指称者也多属债权合同。合同行为并不等于“合同书”，一份合同书中可能包含不只一个合同行为；合同行为也不以做成书面为必要，合同原则上为诺成且不要物的法律行为，只有在例外情形，基于特殊考量（例如公益）时法律会明文要求。\n" +
                        "合同是以双方当事人互相对立合致的意思表示所构成的，其中包括要约及承诺两个基本的意思表示。要约是表意人所发出，欲得到相对人承诺而发生一定私法上效力的意思表示。承诺则是针对要约所为的肯定答复，承诺的内容必须和该要约的内容完全一致，否则即为新要约而非承诺。应与要约区分的是要约之引诱，其并非意思表示，而是观念通知，为准法律行为之一种，不生要约拘束力";
                break;
            case 3:
                contractContent = "疏忽的陈述（Negligent Statement）\n" +
                        "失实陈述（Misrepresentation）\n" +
                        "合同自由原则\n" +
                        "保护第三人效力合同\n" +
                        "涉他合同\n" +
                        "不利于提出者的解说(Contra proferentem)\n" +
                        "合约年期(contractual term)\n" +
                        "不恰当的影响力\n" +
                        "格式合同";
                break;
        }
        content.setText(contractContent);
    }

    private void initView() {
        content = findViewById(R.id.content);
    }
}
