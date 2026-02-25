# Hilt injection bug

This project demonstrates a build issue when attempting to provide a class found in a
flavor-specific directory.

We run the test by choosing to provide either `MyClass` or `MyClassFlavorless` in `SupportModule`:

```kotlin
@InstallIn(SingletonComponent::class)
@Module
abstract class SupportModule {

    @Binds
    abstract fun provideMyInterface(
//        mClass: MyClassFlavourless // enabling this makes the project compile successfully
//        mClass: MyClass // enabling this causes the project to fail to compile
    ): MyInterface
}
```

When satisfying the dependency from `main` the project compiles successfully. However, when
satisfying the dependency from `devCompleteDebug`/`devCompleteRelease` the project fails to compile
with the following error:

```
> Task :support:kspDevCompleteDebugKotlin FAILED
e: [ksp] ModuleProcessingStep was unable to process 'com.zaptec.test.support.SupportModule' because 'MyClass' could not be resolved.

Dependency trace:
    => element (CLASS): com.zaptec.test.support.SupportModule
    => element (METHOD): provideMyInterface(MyClass)
    => element (PARAMETER): mClass
    => type (ERROR parameter type): MyClass

If type 'MyClass' is a generated type, check above for compilation errors that may have prevented the type from being generated. Otherwise, ensure that type 'MyClass' is on your classpath.
e: [ksp] BindingMethodProcessingStep was unable to process 'provideMyInterface(MyClass)' because 'MyClass' could not be resolved.

Dependency trace:
    => element (CLASS): com.zaptec.test.support.SupportModule
    => element (METHOD): provideMyInterface(MyClass)
    => element (PARAMETER): mClass
    => type (ERROR parameter type): MyClass

If type 'MyClass' is a generated type, check above for compilation errors that may have prevented the type from being generated. Otherwise, ensure that type 'MyClass' is on your classpath.

FAILURE: Build failed with an exception.
```

N.B. Debug and Release was created to test if the issue was being caused by release only processes, but the issue can be reproduced in both build types.