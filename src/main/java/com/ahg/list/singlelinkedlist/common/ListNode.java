package com.ahg.list.singlelinkedlist.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"next"})
@AllArgsConstructor
public class ListNode<T> {
    private T data;
    private ListNode<T> next;
}
