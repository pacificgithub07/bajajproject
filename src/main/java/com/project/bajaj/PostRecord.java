package com.project.bajaj;

import java.util.List;

public record PostRecord(
    boolean is_success,
    String user_id,
    String email,
    String roll_number,
    List<String> numbers,
    List<String> alphabets,
    List<String> highest_alphabet
) {}
