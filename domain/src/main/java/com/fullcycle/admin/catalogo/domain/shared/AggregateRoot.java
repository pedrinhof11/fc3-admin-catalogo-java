package com.fullcycle.admin.catalogo.domain.shared;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID>{

    public AggregateRoot(final ID id) {
        super(id);
    }
}
