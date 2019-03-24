package com.example.pocketbook.util.comparators;

import com.example.pocketbook.domain.ReferenceRecord;

import java.util.Comparator;

public class RefRecordComparator implements Comparator<ReferenceRecord> {
    @Override
    public int compare(ReferenceRecord o1, ReferenceRecord o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
