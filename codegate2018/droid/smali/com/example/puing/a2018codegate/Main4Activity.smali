.class public Lcom/example/puing/a2018codegate/Main4Activity;
.super Landroid/support/v7/app/c;


# instance fields
.field l:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v7/app/c;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Landroid/support/v7/app/c;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f0a001e

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main4Activity;->setContentView(I)V

    const v0, 0x7f0800aa

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main4Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main4Activity;->a(Landroid/support/v7/widget/Toolbar;)V

    const v0, 0x7f080047

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main4Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    new-instance v1, Lcom/example/puing/a2018codegate/Main4Activity$1;

    invoke-direct {v1, p0}, Lcom/example/puing/a2018codegate/Main4Activity$1;-><init>(Lcom/example/puing/a2018codegate/Main4Activity;)V

    invoke-virtual {v0, v1}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const-string v0, "native-lib"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    const v0, 0x7f08003e

    invoke-virtual {p0, v0}, Lcom/example/puing/a2018codegate/Main4Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/example/puing/a2018codegate/Main4Activity;->l:Landroid/widget/EditText;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/Main4Activity;->l:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/example/puing/a2018codegate/Main4Activity;->stringFromJNI()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public native stringFromJNI()Ljava/lang/String;
.end method
