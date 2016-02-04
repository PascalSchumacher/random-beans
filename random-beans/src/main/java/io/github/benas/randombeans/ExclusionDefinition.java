package io.github.benas.randombeans;

/**
 * Defines attributes used to identify fields to exclude.
 *
 * @param <T> The target class type
 * @param <F> The field type
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public final class ExclusionDefinition<T, F> {

    private final String name;

    private final Class<F> type;

    private final Class<T> clazz;

    /**
     * Create a new {@link ExclusionDefinition}.
     *
     * @param name the name of the field
     * @param type the type of the field
     * @param clazz the type of the class containing the field
     */
    public ExclusionDefinition(String name, Class<F> type, Class<T> clazz) {
        this.name = name;
        this.type = type;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class<F> getType() {
        return type;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    /*
     * Exclusion definitions are unique according to field name, field type, and class type
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExclusionDefinition that = (ExclusionDefinition) o;

        if (!name.equals(that.name)) return false;
        if (!type.equals(that.type)) return false;
        return clazz.equals(that.clazz);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + clazz.hashCode();
        return result;
    }
}
