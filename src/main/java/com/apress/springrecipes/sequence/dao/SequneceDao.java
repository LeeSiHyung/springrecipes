package com.apress.springrecipes.sequence.dao;

import com.apress.springrecipes.sequence.domain.Sequence;

public interface SequneceDao {
    public Sequence getSequence(String sequenceId);
    public int getNextValue(String sequnceId);
}
