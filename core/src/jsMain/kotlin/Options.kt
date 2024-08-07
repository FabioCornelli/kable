package com.juul.kable

import com.benasher44.uuid.Uuid
import com.juul.kable.Filter as KFilter

@Deprecated(
    message = "Parameter order and type has changed (use filters from com.juul.kable.Filter package).",
    replaceWith = ReplaceWith("Options(filters, optionalServices)"),
    level = DeprecationLevel.ERROR,
)
public fun Options(
    optionalServices: Array<String> = emptyArray(),
    filters: Array<Options.Filter>? = null,
): Options = throw UnsupportedOperationException()

/** https://developer.mozilla.org/en-US/docs/Web/API/Bluetooth/requestDevice */
public data class Options(
    @Deprecated(
        message = "Use filterSets",
        replaceWith = ReplaceWith("filterSets"),
        level = DeprecationLevel.WARNING,
    )
    val filters: List<KFilter>? = null,

    val filterSets: List<FilterSet>? = null,

    /**
     * Access is only granted to services listed as [service filters][KFilter.Service] in [filters]. If any additional
     * services need to be accessed, they must be specified in [optionalServices].
     *
     * https://webbluetoothcg.github.io/web-bluetooth/#device-discovery
     */
    val optionalServices: List<Uuid>? = null,
) {

    @Deprecated(
        message = "Consolidated to `com.juul.kable.Filter`",
        level = DeprecationLevel.WARNING,
    )
    public sealed class Filter {
        @Deprecated(
            message = "Use `com.juul.kable.Filter.Name` instead.",
            level = DeprecationLevel.ERROR,
        )
        public data class Name(val name: String) : Filter()

        @Deprecated(
            message = "Use `com.juul.kable.Filter.NamePrefix` instead.",
            level = DeprecationLevel.ERROR,
        )
        public data class NamePrefix(val namePrefix: String) : Filter()

        @Deprecated(
            message = "Provide each service individually as `com.juul.kable.Filter.Service`.",
            level = DeprecationLevel.ERROR,
        )
        public data class Services(val services: List<Uuid>) : Filter()
    }
}
