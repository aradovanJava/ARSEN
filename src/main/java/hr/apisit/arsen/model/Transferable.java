package hr.apisit.arsen.model;

import java.util.List;

public sealed interface Transferable permits RealEstate {
    void transferOwnership(List<Owner> newOwnersList);
}
